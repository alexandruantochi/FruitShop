package eu.ubis.eshop.pf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	private String filePath;
	private File file;

	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = request.getParameter("description"); // Retrieves
																	// <input
																	// type="text"
																	// name="description">
		Part filePart = request.getPart("file"); // Retrieves <input type="file"
													// name="file">
		String fileName = filePart.getSubmittedFileName();
		InputStream in = filePart.getInputStream();
		
		file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
		OutputStream out =new FileOutputStream(file);
		IOUtils.copy(in,out);
		in.close();
		out.close();
	}

	
}