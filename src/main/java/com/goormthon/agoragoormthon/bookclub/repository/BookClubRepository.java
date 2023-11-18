package com.goormthon.agoragoormthon.bookclub.repository;

import com.goormthon.agoragoormthon.bookclub.domain.BookClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookClubRepository extends JpaRepository<BookClub,Long> {

}
