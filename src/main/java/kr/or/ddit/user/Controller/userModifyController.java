package kr.or.ddit.user.Controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class userModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(userModifyController.class);

	private IuserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	// 사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request 객체로 부터 사용자 아이디 파라미터 획득
		String userId = request.getParameter("userId");

		UserVo db = userService.getUser(userId);

		request.setAttribute("userinfo", db);

		// 사용자 등록 화면으로 이동

		request.getRequestDispatcher("/user/userModify.jsp").forward(request,
				response);

	}

	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("userNm");
		String userId = request.getParameter("userId");
		String alias = request.getParameter("userAlias");
		String addr1 = request.getParameter("userAddr1");
		String addr2 = request.getParameter("userAddr2");
		String zipcd = request.getParameter("userZipcd");
		String pass = request.getParameter("userPass");
		String birth = request.getParameter("userBirth");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserVo userVo = null;
		int abc = 1;

		Part profile = request.getPart("profile");

		String profile2 = request.getParameter("profile");
		logger.debug("profile : {}", profile2);

		// 실제파일명
		String contentDisposition = profile.getHeader("content-disposition");
		String filename = PartUtil.getFileName(contentDisposition);
		String ext = PartUtil.getExt(filename);
		ext = ext.equals("") ? "" : "." + ext;

		String uploadPath = PartUtil.getUploadPath();
		File uploadFolder = new File(uploadPath);
		if (uploadFolder.exists()) {

			// 파일 디스크에 쓰기
			String filePath = uploadPath + File.separator
					+ UUID.randomUUID().toString() + ext;

			logger.debug("userId {}", name);
			logger.debug("userId {}", userId);
			logger.debug("userId {}", alias);
			logger.debug("userId {}", pass);
			logger.debug("userId {}", addr1);
			logger.debug("userId {}", addr2);
			logger.debug("userId {}", zipcd);
			logger.debug("userId {}", filePath);
			logger.debug("userId {}", filename);

			try {
				userVo = new UserVo(name, userId, alias, pass, addr1, addr2,
						zipcd, sdf.parse(birth), filePath, filename);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// userVo.setPath(filePath);
			// userVo.setFilename(filename);
			profile.write(filePath);
			profile.delete();
		}

		if (profile.getSize() <= 0) {
			abc = 0;
		}

		if (abc == 0) {

			response.sendRedirect(request.getContextPath() + "/userPagingList");
			//request.setAttribute("msg", "수정안함");
		}

		else {
			UserVo dbUser = userService.getUser(userId);

			if (dbUser != null) {
				int updateCnt = userService.updateUser(userVo);

				updateCnt = 1;
				response.sendRedirect(request.getContextPath()
						+ "/userPagingList");
				//request.setAttribute("msg", "수정완료.");
			}

		}

	}
}
