package com.lzz.es.repository.book;

import com.lzz.es.pojo.book.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李振振
 * @version 1.0
 * @date 2020/3/1 16:42
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book,String> {

}
