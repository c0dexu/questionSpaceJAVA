package com.example.questionSpace;

import com.example.mdbspringboot.model.Question;
import com.example.questionSpace.repositories.QuestionRepository;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/questions")
public class QuestionServlet extends HttpServlet {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        List<Question> questionList = this.questionRepository.findAll();
        for(Question question  : questionList){
            PrintWriter out = response.getWriter();
            out.println("<div class = \"border card\"></div>");
            out.println("<h3>" + question.getQuestion() +"</h3>");
            out.println(question.getAnswer());
            out.println("<div></div>");
        }
    }

}
