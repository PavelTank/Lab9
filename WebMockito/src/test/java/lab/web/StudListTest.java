package lab.web;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StudListTest {

    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoGetWithName() throws Exception {
        when(request.getParameter("name")).thenReturn("Иванов И.И.");
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);

        StudList servlet = new StudList();
        servlet.doGet(request, response);

        String result = sw.getBuffer().toString().trim();
        assertTrue("Ответ должен содержать имя", result.contains("Иванов И.И."));
        assertTrue("Ответ должен содержать таблицу", result.contains("<table border='1'>"));
        verify(response).getWriter();
    }

    @Test
    public void testDoGetWithoutName() throws Exception {
        when(request.getParameter("name")).thenReturn(null);
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);

        StudList servlet = new StudList();
        servlet.doGet(request, response);

        String result = sw.getBuffer().toString().trim();
        assertTrue("Сервлет должен вывести 'без имени', если name == null", result.contains("без имени"));
    }
}