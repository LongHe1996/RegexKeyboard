package regex.keyboard.domain.regexKeyboard.convertor;

import org.springframework.stereotype.Component;
import regex.keyboard.domain.regexKeyboard.entity.UserE;
import regex.keyboard.infra.dataobject.UserDO;

/**
 * @Description: user convertor.
 * @Author: Eugen
 * @Mail: longhe1996@foxmail.com
 * @CreateDate: 2018/5/21 15:15
 */
@Component
public class UserConvertor implements ConvertorI<UserDO, UserE> {

    @Override
    public UserE doToEntity(UserDO dataObject) {
        return new UserE(dataObject.getId(), dataObject.getUserName(), dataObject.getNickName(), dataObject.getEmail(), dataObject.getDrowssap(), dataObject.getBio(), dataObject.getRegisterTime());
    }

    @Override
    public UserDO entityToDo(UserE entity) {
        return new UserDO(entity.getId(),entity.getUserName(),entity.getNickName(),entity.getEmail(),entity.getDrowssap(),entity.getBio(),entity.getRegisterTime());
    }
}
