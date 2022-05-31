package com.laptrinhjavaweb.service.Impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserName(String userName) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(userName);
        return userConverter.convertToDto(userEntity.get());
    }

    @Override
    public UserDTO findUserById(long id) {
        UserEntity entity = userRepository.findOne(id);
        UserDTO dto = userConverter.convertToDto(entity);
        return dto;
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOne(id);
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setUsername(oldUser.getUsername());
        userEntity.setPassword(oldUser.getPassword());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void updatePassword(long id, PasswordDTO passwordDTO) throws Exception {
        UserEntity user = userRepository.findOne(id);
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new Exception("Change fail");
        }
    }

    @Override
    @Transactional
    public UserDTO resetPassword(long id) {
        UserEntity userEntity = userRepository.findOne(id);
        userEntity.setPassword(passwordEncoder.encode("123456"));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {

        Optional<UserEntity> oldUser = userRepository.findByUsername(username);
        oldUser.ifPresent(userEntity -> userEntity.setEmail(updateUser.getEmail()));

        return userConverter.convertToDto(userRepository.save(oldUser.get()));
    }


}
