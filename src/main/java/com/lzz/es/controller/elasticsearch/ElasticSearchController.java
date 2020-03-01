package com.lzz.es.controller.elasticsearch;

import com.lzz.es.pojo.book.Book;
import com.lzz.es.repository.book.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author 李振振
 * @version 1.0
 * @date 2020/3/1 12:37
 */
@RestController
@Slf4j
public class ElasticSearchController {
    @Autowired
    private BookRepository bookRepository;

    /**
     * es查询
     * @param id
     * @return
     */
    @GetMapping("/getBook")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name="id",defaultValue = "") String id){
        if (id.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Optional<Book> book = bookRepository.findById(id);
        if (!book.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(book,HttpStatus.OK);
    }

    /**
     * es保存
     * @param id
     * @param name
     * @param age
     * @param date
     * @return
     */
    @GetMapping(value = "/add")
    public ResponseEntity add(@RequestParam(name = "id") String id,
                              @RequestParam(name = "name",defaultValue = "") String name,
                              @RequestParam(name = "age",defaultValue = "0") Integer age,
                              @RequestParam(name = "date",defaultValue = "2020-03-01") String date){
         bookRepository.save(new Book(id,name,age,date));
         return new ResponseEntity("save ok",HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity delete(@RequestParam(name = "id") String id){
        bookRepository.deleteById(id);
        return new ResponseEntity("ok",HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity findAll(){
        List<Book> list = new ArrayList<>();
        Iterable<Book> result = bookRepository.findAll();
        Iterator iterator = result.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            list.add(book);
        }
        return new ResponseEntity(list,HttpStatus.OK);
    }
}
