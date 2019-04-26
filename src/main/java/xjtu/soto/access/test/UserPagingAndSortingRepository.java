package xjtu.soto.access.test;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository  extends PagingAndSortingRepository<User,Long> {
}