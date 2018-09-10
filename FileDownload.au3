#include <InetConstants.au3>
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>

; Download a file in the background.
; Wait for the download to complete.

Example()

Func Example()
	; Save the downloaded file to the temporary folder.
	Local $sFilePath = "C:\Chetan\AutoIT\AutoIT_Stuff\DownloadedFiles\IEDriver.zip"

	; Retrieve the number of total bytes received and the filesize.
	Local $iBytesSize = InetGet("https://selenium-release.storage.googleapis.com/3.0/IEDriverServer_x64_3.0.0.zip", $sFilePath, $INET_FORCERELOAD)

EndFunc   ;==>Example
