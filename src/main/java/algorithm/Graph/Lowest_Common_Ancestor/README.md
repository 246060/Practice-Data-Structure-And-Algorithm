
- https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/treealgorithms/LowestCommonAncestorEulerTour.java


# RMQ(Range Minimum Query)을 이용한 LCA

![](https://postfiles.pstatic.net/MjAyMDA4MDRfNjkg/MDAxNTk2NTE3NDE4NTc2.mlRVcELqeLwbwQ6vOWAT998tsCRy-g-DzhyWd7WjKDIg.53vpd6-SiCb-r_d-8ItBVmQyrN8RooAbg6UqV7w3yyEg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMTky/MDAxNTk2NTE3NDIxMzg5.87jgEYHHRg5vAg7VKFSkhs2wlRNPsGpPBjkylC8UuC0g.1WxHBVCGHmnHwiMhslLbi6XCOdKzCAuaCDpxU-IRrDEg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfNSAg/MDAxNTk2NTE3NDI0MjI5.yjwsR_l1vm5-El4Lt-1UKbExhGj2i4VKWlqAfgEFHiog.n5kc-iuCMUQdNYAEnau0sj1soNFlBlXEzXleKbS5AhUg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMjk3/MDAxNTk2NTE3NDI2Njc0.EcSqBkESwsIn0pF5V9Dt_oTce3J_Hl_Yh6EAf_zZcGAg.YMi39DHHAzRYUNsp6arkxn-HbdiXuRom8Rt9eesMUwUg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMTgy/MDAxNTk2NTE3NDI4ODI0.toAirFuHtCdjZTw78TLd2-XUEO0IaNUOHZuwDzKbFeMg.Zzx8S4U53lLtJDAU11F2AmiaHs4rSK0g9H9XfL52zjEg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMjI0/MDAxNTk2NTE3NDMyNjI2.6qElq_jCJkO7rEmKEM7OGKivgYCjwkd0-AHnhgnW920g.IQx8KVww21TnD4GjuQNiulDmD1ECriRin7NCikbkp1Qg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMjI4/MDAxNTk2NTE3NDM1MDg2.KbVEVnyOEzbikGIrfsQRpfRjvjDcuqbedYztzvOAkFMg.OeZDFR58jHZ6OGiZtXOkPYWskYt736-xDZjMHqb2EJgg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMjMy/MDAxNTk2NTE3NjUwMDc3.ifHiu4UyOEyZtJdnRh0Zl2jD9QU5zhNHzanY_gmG7ggg.PaT-PnhuovOmilb1w7Fm9qFprwLAlIhrQjKNImfifcMg.PNG.jqkt15/SE-7e914304-1a7e-42b4-9292-5691c26f8c47.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfMTI2/MDAxNTk2NTE3NDQwMTMw.vTGA9r2KER3zuPeUVQnA4QdK_rLVEk6ud-SEbKX57Iwg.i7ViP5Jr7jLkTDTrdoy6PbDjqEcwF540cO4g5tjhVMgg.PNG.jqkt15/image.png?type=w773)
![](https://postfiles.pstatic.net/MjAyMDA4MDRfNjMg/MDAxNTk2NTE3NzczOTU3.Apz5eDMCKnUf0J24O9XV2z9KExgx2KaMXQ91w5wkCeog.R7TXgdyVcpIS59gLEQx-9vHdVU6XcsZAXu51EYD10Bwg.PNG.jqkt15/image.png?type=w773)