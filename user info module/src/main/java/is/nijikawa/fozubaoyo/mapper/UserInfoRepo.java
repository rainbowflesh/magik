package is.nijikawa.fozubaoyo.mapper;

import is.nijikawa.fozubaoyo.model.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * jpa自定义查询实现
 */
@Repository
public interface UserInfoRepo extends JpaRepository<Info, Long> {
    @Query("select i from Info i where i.login_name=?1")
    List<Info> findByName(@Param("login_name") String login_name);
}