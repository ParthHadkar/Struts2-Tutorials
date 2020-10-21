import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;




public class Test {

	public static void main(String[] args) {
		File file1 = new File("./UserImage");
		File file2 = new File(Paths.get("./P11FileUploadInterceptor/src/main/webapp/UserImage").toAbsolutePath().toString());
		try {
			FileInputStream fis = new FileInputStream(file2.getCanonicalPath().replace("/TestPath", "")+"/UserImage.png");
			int i = 0;
			FileOutputStream  stream = new FileOutputStream(file1+"/UserImage1.png");
			while((i=fis.read())!=-1) {
				stream.write(i);
			}
			stream.flush();
			stream.close();
		//filePath+File.separator+imageName);
		System.out.println("FilePath:-/P11FileUploadInterceptor/"+
				"\nFilePath:-"+stream.toString()+
				"\nfile1:-"+file1.getCanonicalPath().toString()+
				"\nfile2:-"+file2.getCanonicalPath().toString()+
				"\npath:-"+Paths.get("UserImage").toAbsolutePath().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
