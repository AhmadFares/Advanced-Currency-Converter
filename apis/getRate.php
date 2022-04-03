<?php


$ch = curl_init('https://lirarate.org/');
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($ch);
$error = curl_error($ch);

preg_match_all('/<strong id="buy-value">(.*)<\/strong>' , $response , $matches);

print_r($matches);
curl_close($ch);

?>
