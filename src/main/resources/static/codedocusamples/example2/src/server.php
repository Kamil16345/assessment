<?php
if (isset($_GET["wait"])) {
   sleep($_GET["wait"]);
}

$action=$_GET["action"];

if ($action=="download") {
   header("content-type: text/plain");
   header("Content-Disposition: attachment; filename=Download.txt");
   echo "hello";

} else {
  header("content-type: text/plain");
  echo "hello from mavoco ".time();
}

?>
