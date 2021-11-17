package io.zbqmgldjfh.coronavirustracker.persistence;

import io.zbqmgldjfh.coronavirustracker.models.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
