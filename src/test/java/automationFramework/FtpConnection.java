package automationFramework;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;

class FtpConnection {
	
	@Test

	public void FtpTests() throws IOException {
		FTPClient client = new FTPClient();
		boolean result;
		try {
			client.connect("speedtest.tele2.net");
			result = client.login("anonymous", "anonymous");

			if (result == true) {
				System.out.println("User successfully logged in.");
			} else {
				System.out.println("Login failed!");
				return;
			}
			FTPFile[] files = client.listDirectories();
			System.out.println("List of Directory on Ftp Server: ");
			for (FTPFile file : files) {
				System.out.println("Directory name : " + file.getName());
				String directoryName = file.getName();
				// Open existing directory
				client.changeWorkingDirectory("/" + directoryName);
				showServerReply(client);
				// Go to parent directory
				client.cdup();
				showServerReply(client);
			}

			final String dirToCreate = "/test";
			boolean mkdir = client.makeDirectory(dirToCreate);
			showServerReply(client);
			if (mkdir) {
				System.out.println("New directory succesfully created");
				client.removeDirectory(dirToCreate);
				System.out.println("New directory succesfully deleted");
			} else {
				System.out.println("Permission denied. Can't create new directory.");
			}

		} catch (FTPConnectionClosedException e) {
			System.out.println(e);
		} finally {
			try {
				client.logout();
				client.disconnect();
			} catch (FTPConnectionClosedException e) {
				System.out.println(e);
			}
		}
	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
}