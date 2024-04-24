package ru.edu.springdata.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.edu.springdata.model.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookDaoImpl implements BookDao {

    JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Book> getBook(int id) {

        List<Book> list = jdbcTemplate.query("select * from books where id = ?", new BeanPropertyRowMapper<>(Book.class), id);
        return list.stream().findFirst();
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from books", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public int deleteBook(int id) {
        return jdbcTemplate.update("delete from books where id = ?", id);
    }

    @Override
    public int updateBook(Book book) {
        return jdbcTemplate.update("update books set name = ?, language = ?, category = ? where id = ?"
                , book.getName()
                , book.getLanguage()
                , book.getCategory()
                , book.getId());
    }

    @Override
    public int addBook(Book book) {
        return jdbcTemplate.update("insert into books (id, name, language, category) values (?, ?, ?, ?)"
                , book.getId()
                , book.getName()
                , book.getLanguage()
                , book.getCategory());
    }

    @Override
    public void init() {
        jdbcTemplate.execute(
                " CREATE TABLE IF NOT EXISTS books (\n" +
                "     id INTEGER PRIMARY KEY,\n" +
                "     name character varying(255) NOT NULL,\n" +
                "     language character varying(255),\n" +
                "     category character varying(255)\n" +
                " )");
    }
}
