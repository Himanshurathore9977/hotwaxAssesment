package com.hotwaxx.Assesment.repository;

import com.hotwaxx.Assesment.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepo extends JpaRepository<Party , String > {
}

