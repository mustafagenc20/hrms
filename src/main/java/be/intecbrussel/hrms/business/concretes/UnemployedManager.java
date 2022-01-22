package be.intecbrussel.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnemployedManager implements UnemployedService{

    private UnemployedDao unemployedDao;
    private MernisService mernisService;
    private PhotoService photoService;

    @Autowired
    public UnemployedManager(UnemployedDao unemployedDao, MernisService mernisService, PhotoService photoService) {
        super();
        this.unemployedDao = unemployedDao;
        this.mernisService = mernisService;
        this.photoService = photoService;
    }

    @Override
    public Result addUnemployed(UnemployedRegisterDto unemployedDto) {
        if(this.unemployedDao.getByNationalityId(unemployedDto.getNationalityId()) == null) {
            if(this.mernisService.checkIfRealPerson(unemployedDto)) {
                Unemployed unemployed = new Unemployed();
                unemployed.setEmail(unemployedDto.getEmail());
                unemployed.setPassword(unemployedDto.getPassword());
                unemployed.setFirstName(unemployedDto.getFirstName());
                unemployed.setLastName(unemployedDto.getLastName());
                unemployed.setNationalityId(unemployedDto.getNationalityId());
                unemployed.setBirthDate(unemployedDto.getBirthDate());
                unemployed.setPhoneNumber(unemployedDto.getPhoneNumber());
                this.unemployedDao.save(unemployed);
                this.photoService.newRegister(unemployed.getUserId());
                return new SuccessResult("Kayıt işlemi başarılı.");
            }
        }
        return new ErrorResult("Kimlik bilgisi hatalı. Kontrol edip tekrar deneyin.");
    }

    @Override
    public DataResult<List<Unemployed>> getAll() {
        return new SuccessDataResult<List<Unemployed>>(this.unemployedDao.findAll(), "İş arayanlar listelendi.");
    }

    @Override
    public DataResult<Unemployed> getByNationalityId(String nationalityId) {
        return new SuccessDataResult<Unemployed>(this.unemployedDao.getByNationalityId(nationalityId), "TC Numarasına göre data getirildi. ");
    }

    @Override
    public DataResult<Unemployed> getByEmail(String email) {
        return new SuccessDataResult<Unemployed>(this.unemployedDao.getByEmail(email),"Email adresine göre data listelendi.");
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