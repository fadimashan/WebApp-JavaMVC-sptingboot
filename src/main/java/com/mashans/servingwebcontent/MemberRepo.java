package com.mashans.servingwebcontent;

import com.mashans.servingwebcontent.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepo extends CrudRepository<Member, Long> {
}
