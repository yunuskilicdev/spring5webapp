package kilic.yunus.spring5webapp.controller;

import kilic.yunus.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControl {

    private BookRepository bookRepository;

    public BookControl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBook(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "books";
    }
}
