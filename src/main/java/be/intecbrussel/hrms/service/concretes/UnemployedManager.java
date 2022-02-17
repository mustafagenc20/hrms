package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.PhotoService;
import be.intecbrussel.hrms.service.abstracts.UnemployedService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Unemployed;
import be.intecbrussel.hrms.model.dtos.UnemployedRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnemployedManager implements UnemployedService {

    private final UnemployedDao unemployedDao;
    private final PhotoService photoService;

    @Override
    public Result addUnemployed(UnemployedRegisterDto unemployedDto) {
        if (this.unemployedDao.getByNationalityId(unemployedDto.getNationalityId()) == null) {

            Unemployed unemployed = new Unemployed();
            unemployed.setEmail(unemployedDto.getEmail());
            unemployed.setPassword(unemployedDto.getPassword());
            unemployed.setFirstName(unemployedDto.getFirstName());
            unemployed.setLastName(unemployedDto.getLastName());
            unemployed.setNationalityId(unemployedDto.getNationalityId());
            unemployed.setBirthDate(unemployedDto.getBirthDate());
            unemployed.setPhoneNumber(unemployedDto.getPhoneNumber());
            Unemployed save = unemployedDao.save(unemployed);

            this.photoService.newRegister(save.getUserId());
            return new SuccessResult("The registration is successful.");

        }
        return new ErrorResult("Identity information is incorrect. Check and try again.");
    }

    @Override
    public DataResult<List<Unemployed>> getAll() {
        return new SuccessDataResult<List<Unemployed>>(this.unemployedDao.findAll(), "Job seekers listed.");
    }

    @Override
    public DataResult<Unemployed> getByNationalityId(String nationalityId) {
        return new SuccessDataResult<Unemployed>(this.unemployedDao.getByNationalityId(nationalityId), "Data was retrieved according to Identity Number.");
    }

    @Override
    public DataResult<Unemployed> getByEmail(String email) {
        return new SuccessDataResult<Unemployed>(this.unemployedDao.getByEmail(email),"The data is listed according to the e-mail address.");
    }

    @Override
    public DataResult<List<Unemployed>> getByMailIsVerifyTrue() {
        return new SuccessDataResult<List<Unemployed>>(this.unemployedDao.getByMailIsVerifyTrue());
    }

    @Override
    public DataResult<Unemployed> getByUserId(int userId) {
        return new SuccessDataResult<Unemployed>(this.unemployedDao.getByUserId(userId));
    }
}
