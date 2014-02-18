import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReadCSV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String csvFileToRead = "csvFiles/shareData.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvFileToRead));
			String line = "";
			StringTokenizer st = null;

			int lineNumber = 0;
			int tokenNumber = 0;

			// read comma separated file line by line
			while ((line = br.readLine()) != null) {
				lineNumber++;

				if (lineNumber > 1) {

					// use comma as token separator
					st = new StringTokenizer(line, ",");

					CompanyDataBean companyDataBean = new CompanyDataBean();
					while (st.hasMoreTokens()) {
						tokenNumber++;
						String toketn = st.nextToken();
						if (tokenNumber == 1) {
							companyDataBean.setYear(Integer.parseInt(toketn));
						} else if (tokenNumber == 2) {
							companyDataBean.setMonth(toketn);
						} else {

							if (Integer.parseInt(toketn) >= companyDataBean.getHighestValue()) {
								companyDataBean.setHighestValue(Integer.parseInt(toketn));
							}
						}

					}
					System.out.println(" Year : " + companyDataBean.getYear() + "  Month : " + companyDataBean.getMonth() + "  HighestValue : " + companyDataBean.getHighestValue());

				}


				// reset token number
				tokenNumber = 0;
			}

		} catch (Exception e) {
			System.err.println("CSV file cannot be read : " + e);
		}
		System.out.println("Done with reading CSV");
	}

}
