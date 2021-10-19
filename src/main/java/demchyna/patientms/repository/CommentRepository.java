package demchyna.patientms.repository;

import demchyna.patientms.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select id, text, created_at, patient_id from comments where patient_id = ?1 order by created_at", nativeQuery = true)
    List<Comment> readCommentsByPatientId(long patientId);
}
