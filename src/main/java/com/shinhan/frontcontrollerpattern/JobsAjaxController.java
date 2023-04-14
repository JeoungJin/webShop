package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.model.CompanyService;
import com.shinhan.vo.JobVO;

public class JobsAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		//모든job조회하기
		CompanyService service = new CompanyService();
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		List<JobVO> joblist = service.jobSelectAll();
		request.setAttribute("jobList", joblist);
		
		//1)JavaScript로 작성된 ajax부분에 전달하는 방법1---JSP만들어서보낸다.(HTML디자인)
		//return "jobView.jsp";
		
		//2)JavaScript로 작성된 ajax부분에 전달하는 방법2---JSON만들어서보낸다.(JS로디자인)
		JSONArray arr = new JSONArray(); //[]
		JSONObject obj = null; //{}
		for(JobVO job:joblist) {
			obj = new JSONObject();//{"job_id":'IT','job_title':'aa' }
			obj.put("job_id", job.getJob_id());
			obj.put("job_title", job.getJob_title());
			arr.add(obj); //[{"job_id":'IT','job_title':'aa' },{"job_id":'IT','job_title':'aa' },{}   ]
		}
		//'{"jobList":[{"job_id":'IT'},{},{}   ]}'
		JSONObject jobsObj = new JSONObject();
		jobsObj.put("jobList", arr);
		 
		return "responseBody:" + jobsObj.toJSONString();
	}

}
