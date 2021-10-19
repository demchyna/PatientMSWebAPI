package demchyna.patientms.service.impl;

import demchyna.patientms.exception.NullReferenceEntityException;
import demchyna.patientms.model.Comment;
import demchyna.patientms.repository.CommentRepository;
import demchyna.patientms.repository.PatientRepository;
import demchyna.patientms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PatientRepository patientRepository) {
        this.commentRepository = commentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Comment create(Comment comment) {
        if (comment != null) {
            return commentRepository.save(comment);
        }
        throw new NullReferenceEntityException("The comment cannot be 'null'");
    }

    @Override
    public Comment readById(long id) {
        return commentRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("The comment with id " + id + " not found"));
    }

    @Override
    public Comment update(Comment comment) {
        if (comment != null) {
            readById(comment.getId());
            return commentRepository.save(comment);
        }
        throw new NullReferenceEntityException("The comment cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        Comment comment = readById(id);
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> readCommentsByPatientId(long patientId) {
        patientRepository.findById(patientId).orElseThrow(()
                -> new EntityNotFoundException("The patient with id " + patientId + " not found"));
        return commentRepository.readCommentsByPatientId(patientId);
    }
}
