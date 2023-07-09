package kr.kro.intellijung.board.user.application;

import kr.kro.intellijung.board.user.application.dto.AccountDto;
import kr.kro.intellijung.board.user.domain.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    Account AccountDtoToAccount(AccountDto accountDto);
}
