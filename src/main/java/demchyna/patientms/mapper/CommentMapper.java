package demchyna.patientms.mapper;

import demchyna.patientms.dto.CommentDto;
import demchyna.patientms.model.Comment;
import demchyna.patientms.service.PatientService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { PatientService.class })
public interface CommentMapper {

    @Mapping(source = "patient.id", target = "patientId")
    CommentDto toDto(Comment comment);

    @Mapping(source = "patientId", target = "patient")
    Comment toEntity(CommentDto commentDto);
}
