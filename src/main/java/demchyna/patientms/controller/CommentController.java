package demchyna.patientms.controller;

import demchyna.patientms.dto.CommentDto;
import demchyna.patientms.mapper.CommentMapper;
import demchyna.patientms.model.Comment;
import demchyna.patientms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@RequestBody CommentDto commentDto) {
        return commentMapper.toDto(
                commentService.create(
                        commentMapper.toEntity(commentDto)));
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CommentDto readById(@PathVariable long id) {
        return commentMapper.toDto(commentService.readById(id));
    }

    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    public CommentDto update(@RequestBody CommentDto commentDto) {
        return commentMapper.toDto(
                commentService.update(
                        commentMapper.toEntity(commentDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        commentService.delete(id);
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CommentDto> readCommentsByPatientId(@PathVariable long id) {
        return commentService.readCommentsByPatientId(id).stream()
                .map(commentMapper::toDto).collect(Collectors.toList());
    }
}
