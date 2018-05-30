package regex.keyboard.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regex.keyboard.api.dto.UserDTO;
import regex.keyboard.domain.regexKeyboard.convertor.UserConvertor;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.domain.repository.UserRepository;
import regex.keyboard.domain.service.UserService;
import regex.keyboard.infra.dataobject.UserDO;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConvertor userConvertor;

    @Override
    public UserDTO create(UserE userE) {
        UserDO userDO = userConvertor.entityToDo(userE);
        UserDO saveUserDO = userRepository.save(userDO);
        return new UserDTO(userConvertor.doToEntity(saveUserDO), "success.create.user:" + saveUserDO,true);
    }

    @Override
    public UserDTO deleteById(Long id) {
        //1.user不存在
        if (userRepository.findOne(id) == null)
            return  new UserDTO(null,"error.delete.user.not.exist.id:" + id,false);
        userRepository.delete(id);
        return new UserDTO(null,"success.delete.user.id:" + id,true);
    }

    @Override
    public UserDTO update(UserE userE) {
        UserDO userDO = userConvertor.entityToDo(userE);
        //1.user不存在
        if (userRepository.findOne(userDO.getId()) == null) {
            return new UserDTO(null, "error.update.user.not.exist." + userDO.getId(),false);
        }
        UserDO updateUserDO = userRepository.save(userDO);
        return new UserDTO(userConvertor.doToEntity(updateUserDO), "success.update.user:" + updateUserDO,true);
    }

    @Override
    public UserDTO selectById(Long id) {
        UserDO userDO = userRepository.findOne(id);
        if(userDO==null){
            return new UserDTO(null, "error.select.user.not.exist.id:" + id,false);
        }
        return new UserDTO(userConvertor.doToEntity(userDO),"success.select.user.id:"+userDO,true);
    }

    @Override
    public UserDTO selectByUserName(String userName) {
        UserDO byUserName = userRepository.findByUserName(userName);
        if(byUserName==null){
            return  new UserDTO(null,"error.select.user.by.username.not.exist.username:"+userName,false);
        }
        return new UserDTO(userConvertor.doToEntity(byUserName),"success.select.user.by.username:"+userName,true);
    }

    @Override
    public UserDTO selectByEmail(String email) {
        UserDO byEmail = userRepository.findByEmail(email);
        if(byEmail==null){
            return new UserDTO(null,"error.select.user.by.email.not.exist.email:"+email,false);
        }
        return new UserDTO(userConvertor.doToEntity(byEmail),"success.select.user.by.emial:"+email,true);
    }

    @Override
    public UserDTO selectByUserNameAndDrowssap(String userName, String drowssap) {
        UserDO byUserNameAndDrowssap = userRepository.findByUserNameAndDrowssap(userName, drowssap);
        if(byUserNameAndDrowssap==null){
            return new UserDTO(null,"error.select.by.username.and.drowssap.not.exist",false);
        }
        return new UserDTO(userConvertor.doToEntity(byUserNameAndDrowssap),"success.select.by.username.and.drowssap",true);
    }

}
