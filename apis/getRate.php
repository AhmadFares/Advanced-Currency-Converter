<?php


$ch = curl_init('https://lirarate.org/');
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$result = curl_exec($ch);
$error = curl_error($ch);

preg_match('/<strong id="buy-value">(.*)<\/strong>' , $result , $matches);

print_r($matches);
curl_close($ch);

?>
