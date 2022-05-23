package com.pdp.utilities;

public class ExceptionHandler {
	
	public static void main(Exception  excp, String pageName) throws Throwable {
				
	}
	
	public static void handler (Exception excp, String pageName) throws Throwable{
		if(excp.toString().contains("AssertionError")) {
			assertionHandler(excp);
		}
		else if(excp.toString().contains("NoSUchElementException")) {
			noElementHandler(excp,pageName);
		}
		else if(excp.toString().contains("staleElementReferanceException")) {
			staleElementHandler(excp,pageName);
		}
		else if (excp.toString().contains("elementsNotVisibleException")) {
			notVisibleHandler(excp,pageName);
		}
		else if (excp.toString().contains("WebDriverException")) {
			if(excp.toString().contains("Element Not Clickable")) {
				
				elementNotClickableHandler(excp,pageName);
			}else {
				webElementGenericHandler(excp,pageName);
			}
		}
		else {
			System.out.println("Size "+excp.getStackTrace().length);
			genericHandler(excp,pageName);
		}
	}
	
	public static void assertionHandler(Exception assrExcp) throws Throwable{
		printStacktrace (assrExcp);
		Log.info("Validation failed "+assrExcp);
		throw new Throwable ("Validation failed "+assrExcp);
		
	}
	
	public static void noElementHandler(Exception nseExcp, String pageName) throws Throwable{
		printStacktrace (nseExcp);
		Log.info("Expected element not found on  page "+pageName+nseExcp);
		throw new Throwable ("Expected element not found on  page "+pageName+nseExcp);

	}
	
	public static void staleElementHandler(Exception staleExcp, String pageName) throws Throwable{
		printStacktrace (staleExcp);
		Log.info("page loaded but state of element can not be handled "+pageName+staleExcp);
		throw new Throwable ("page loaded but state of element can not be handled "+pageName+staleExcp);

	}
	
	public static void notVisibleHandler(Exception notVisibleExcp, String pageName) throws Throwable{
		printStacktrace (notVisibleExcp);
		Log.info("Expeted element nt visible on page "+pageName+notVisibleExcp);
		throw new Throwable ("Expeted element nt visible on page "+pageName+notVisibleExcp);

	}
	public static void elementNotClickableHandler(Exception notClickableExcp, String pageName) throws Throwable{
		printStacktrace (notClickableExcp);
		Log.info("Expeted element not clickable on page "+pageName+notClickableExcp);
		throw new Throwable ("Expeted element nt clickable on page "+pageName+notClickableExcp);

	}
	
	public static void webElementGenericHandler(Exception wegExcp, String pageName) throws Throwable{
		printStacktrace (wegExcp);
		Log.info("Webdriver is not ableto handle on page "+pageName+wegExcp);
		throw new Throwable ("Webdriver is not ableto handle on page "+pageName+wegExcp);

	}
	
	public static void genericHandler(Exception genExcp, String pageName) throws Throwable{
		printStacktrace (genExcp);
		Log.info("Unpected error occured on page "+pageName+genExcp);
		throw new Throwable ("Unpected error occured on page "+pageName+genExcp);

	}

	
	public static void printStacktrace(Exception exp) {
		for(int index=0; index< exp.getStackTrace().length;index++) {
			Log.info("Error found at line number: "+exp.getStackTrace()[index].getLineNumber()+", for Method: "+exp.getStackTrace()[index].getMethodName()+" , in class "+exp.getStackTrace()[index].getClassName());
			System.out.println("Error found at line number: "+exp.getStackTrace()[index].getLineNumber()+", for Method: "+exp.getStackTrace()[index].getMethodName()+" , in class "+exp.getStackTrace()[index].getClassName());
			Log.info(exp.getStackTrace()[index].toString());
			System.out.println(exp.getStackTrace()[index].toString());
		}
		
	}

}
