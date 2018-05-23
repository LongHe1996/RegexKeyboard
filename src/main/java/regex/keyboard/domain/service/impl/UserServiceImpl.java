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
        //1.userId重复
        if (userRepository.findByUserId(userDO.getUserId()) != null) {
            return new UserDTO(null, "error.create.user.userid.exist.");
        }
        UserDO saveUserDO = userRepository.save(userDO);
        return new UserDTO(userConvertor.doToEntity(saveUserDO), "success.create.user:" + saveUserDO);
    }

    @Override
    public String deleteById(Long id) {
        //1.user不存在
        if (userRepository.findOne(id) == null)
            return "error.delete.user.not.exist.id:" + id;
        userRepository.delete(id);
        return "success.delete.user.id:" + id;
    }

    @Override
    public UserDTO update(UserE userE) {
        UserDO userDO = userConvertor.entityToDo(userE);
        //1.user不存在
        if (userRepository.findOne(userDO.getId()) == null) {
            return new UserDTO(null, "error.update.user.not.exist." + userDO.getId());
        }
        UserDO updateUserDO = userRepository.save(userDO);
        return new UserDTO(userConvertor.doToEntity(updateUserDO), "success.update.user:" + updateUserDO);
    }

    @Override
    public UserDTO selectByUserId(Long userId) {
        UserDO userDO = userRepository.findByUserId(userId);
        if (userDO == null) {
            return new UserDTO(null, "error.select.user.not.exist.userid:" + userId);
        }
        return new UserDTO(userConvertor.doToEntity(userDO), "success.select.user.userid:" + userDO);
    }

    @Override
    public UserDTO selectById(Long id) {
        UserDO userDO = userRepository.findOne(id);
        if(userDO==null){
            return new UserDTO(null, "error.select.user.not.exist.id:" + id);
        }
        return new UserDTO(userConvertor.doToEntity(userDO),"success.select.user.id:"+userDO);
    }
}
