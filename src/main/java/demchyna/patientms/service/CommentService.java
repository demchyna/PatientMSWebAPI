package demchyna.patientms.service;

import demchyna.patientms.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment create(Comment comment);
    Comment readById(long id);
    Comment update(Comment comment);
    void delete(long id);

    List<Comment> getAll();

    List<Comment> readCommentsByPatientId(long patientId);
}
