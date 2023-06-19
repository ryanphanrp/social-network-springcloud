package com.ryan.domain.dao.implement;

import com.ryan.domain.dao.UserFollowDao;
import com.ryan.domain.entity.UserFollow;
import com.ryan.domain.entity.pojo.UserFollowDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserFollowDaoImpl implements UserFollowDao {

    private EntityManager entityManager;

    @Override
    public UserFollowDetail getUserFollowDetail(Long userId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createTupleQuery();
        Root<UserFollow> root = query.from(UserFollow.class);

        Predicate fromUserCondition = builder.equal(root.get("fromUserId"), userId);
        Predicate toUserCondition = builder.equal(root.get("toUserId"), userId);
        Predicate whereCondition = builder.or(fromUserCondition, toUserCondition);

        var fromUserSelect = builder.selectCase()
                .when(fromUserCondition, 1);
        var toUserSelect = builder.selectCase()
                .when(toUserCondition, 1);

        Expression<Long> fromUserCountEx = builder.count(fromUserSelect);
        Expression<Long> toUserCountEx = builder.count(toUserSelect);

        query.select(builder.tuple(
                fromUserCountEx.alias("from_user_count"),
                toUserCountEx.alias("to_user_count")
        )).where(whereCondition);

        TypedQuery<Tuple> typedQuery = entityManager.createQuery(query);
        Tuple result = typedQuery.getSingleResult();

        return UserFollowDetail.builder()
                .followers(result.get("to_user_count", Long.class))
                .following(result.get("from_user_count", Long.class))
                .build();
    }
}
