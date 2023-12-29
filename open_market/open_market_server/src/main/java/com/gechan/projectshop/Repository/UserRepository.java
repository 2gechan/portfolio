package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.user.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, String> {
}
