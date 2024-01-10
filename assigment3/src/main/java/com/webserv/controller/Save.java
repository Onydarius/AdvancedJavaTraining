package com.webserv.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.webserv.dao.ProductDao;
import com.webserv.model.Product;

@WebServlet("/save")
@MultipartConfig(maxFileSize = 1048576, maxRequestSize = 104857600)
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductDao productDao;
	
    public void init() {
    	productDao = new ProductDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Product product =  new Product();
		
		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String size = request.getParameter("size");
		Part filePart = request.getPart("image");
		
        String fileName = getSubmittedFileName(filePart);

      
        
		product.setTitle(title);
		product.setQuantity(quantity);
		product.setSize(size);
		
		productDao.save(product);
		
		
		 String uploadDirectory = getServletContext().getRealPath("/") + "src/main/resources/"+product.getId(); // Cambia esto según tu configuración


		 File uploadFile = new File(uploadDirectory, fileName);
	        // Guarda el archivo en una ubicación en el servidor
		 
	     uploadFile.getParentFile().mkdirs();
        

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }


		
	     product.setImageLink(fileName);

	     productDao.update(product);
		
		response.sendRedirect("/Product/all");
		
	}
	
	
	private String getSubmittedFileName(Part part) {
        // Obtiene el nombre original del archivo desde la cabecera 'Content-Disposition' de la parte
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
