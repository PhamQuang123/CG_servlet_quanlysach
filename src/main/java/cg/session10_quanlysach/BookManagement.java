package cg.session10_quanlysach;

import cg.session10_quanlysach.model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookManagement", value = "/BookManagement")
public class BookManagement extends HttpServlet {
    private List<Book> listBooks = new ArrayList<>();


    public void init() {
        listBooks.add(new Book(1, "Doraemon", 200, "Truyện thiếu nhi", "Fujiko"));
        listBooks.add(new Book(2, "Sự im lặng của bày cừu", 350, "Truyện thiếu nhi", "Stephen King"));
        listBooks.add(new Book(3, "It", 100, "Kinh dị", "Stephen King"));
        listBooks.add(new Book(4, "Sự tích ngu của Ngô Tiến", 500, "Truyện c tích", "Tiến Ngô"));
        listBooks.add(new Book(5, "Tiểu thuyết sống lỗi của Minh Tiến", 800, "Tiểu thuyết", "Minh Tiến"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch (action){
            case "findAll":
                findAll(request, response);
                break;
            case "initCreate":
                initCreate(request,response);
                break;
            case "delete":
                doDeleteBook(request,response);
                break;
            case "edit":
                editBook(request,response);
                break;
        }

    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("book.jsp").forward(request,response);
    }

    public void initCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("createBook.jsp").forward(request,response);
    }

    public void doDeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deleteId = Integer.parseInt(request.getParameter("id"));
        listBooks.remove(findById(deleteId));
        findAll(request,response);
    }

    public void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int updateId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("book",findById(updateId));
        request.getRequestDispatcher("updateBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        switch (action){
            case "create":
                doCreate(request, response);
                break;
            case "update":
                doUpdate(request,response);
                break;
        }
    }

    public void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book createBook =new Book();
        createBook.setBookId(autoIncrementId());
        createBook.setBookName(request.getParameter("bookName"));
        createBook.setPrice(Float.parseFloat(request.getParameter("price")));
        createBook.setDescription(request.getParameter("description"));
        createBook.setAuth(request.getParameter("auth"));
        listBooks.add(createBook);
        findAll(request,response);
    }

    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int updateId = Integer.parseInt(request.getParameter("bookId"));
        Book bookUpdate = findById(updateId);
        bookUpdate.setBookName(request.getParameter("bookName"));
        bookUpdate.setPrice(Float.parseFloat(request.getParameter("price")));
        bookUpdate.setDescription(request.getParameter("description"));
        bookUpdate.setAuth(request.getParameter("auth"));
        findAll(request,response);
    }

    public Book findById(int id){
        for (Book b: listBooks
             ) {
            if (b.getBookId() == id){
                return b;
            }
        }
        return null;
    }

    public int autoIncrementId(){
        int maxId = 0;
        if (listBooks.size() == 0){
            maxId = 0;
        }else {
            for (Book book: listBooks
                 ) {
                if (book.getBookId() > maxId){
                    maxId = book.getBookId();
                }
            }
        }
        maxId++;
        return maxId;
    }
}
