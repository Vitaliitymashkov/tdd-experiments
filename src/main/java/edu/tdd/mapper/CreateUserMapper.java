package edu.tdd.mapper;

import edu.tdd.dto.CreateUserDto;
import edu.tdd.entity.Gender;
import edu.tdd.entity.Role;
import edu.tdd.entity.User;
import edu.tdd.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public User map(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.findOpt(object.getGender()).orElse(null))
                .role(Role.findOpt(object.getRole()).orElse(null))
                .build();
    }
}
