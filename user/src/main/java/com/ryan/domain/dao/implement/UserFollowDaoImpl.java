package com.ryan.domain.dao.implement;

import com.ryan.domain.dao.UserFollowDao;
import com.ryan.domain.entity.UserFollow;
import com.ryan.domain.entity.pojo.UserFollowDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserFollowDaoImpl implements UserFollowDao {

  private EntityManager entityManager;

  @Override
  public UserFollowDetail getUserFollowDetail(Long userId) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<UserFollowDetail> query = builder.createQuery(UserFollowDetail.class);

    // TODO: build criteria query here
    Root<UserFollow> root = query.from(UserFollow.class);
    var fromUserId = root.get("fromUserId");
    var toUserId = root.get("toUserId");

    var countFrom = builder.count(fromUserId);
    var countTo = builder.count(toUserId);

    Predicate whereClause = builder.or(
        builder.equal(fromUserId, userId),
        builder.equal(toUserId, userId)
    );
    query.multiselect(countFrom, countTo)
        .where(whereClause);

    return entityManager.createQuery(query)
        .getSingleResult();
  }
}
