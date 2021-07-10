package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
    private CoverLetter coverLetter;
    private List<Image> images;
    private List<ResumeItTechnology> resumeItTechnologies;
    private List<ResumeLanguage> resumeLanguages;
    private List<Education> educations;
    private List<WorkExperience> workExperiences;
    private List<Link> links;
}
