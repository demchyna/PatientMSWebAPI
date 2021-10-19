package demchyna.patientms.controller;

import demchyna.patientms.model.Comment;
import demchyna.patientms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Comment readById(@PathVariable long id) {
        return commentService.readById(id);
    }

    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public Comment update(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        commentService.delete(id);
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Comment> readCommentsByPatientId(@PathVariable long id) {
        return commentService.readCommentsByPatientId(id);
    }
}
