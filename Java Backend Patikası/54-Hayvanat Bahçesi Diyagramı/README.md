# Kodluyoruz Back-End Java Eğitimi 054

Bu repo [Kodluyoruz](https://www.kodluyoruz.org) Back-End Java Eğitiminde 
oluşturduğum projelerdendir.

---
## Object Oriented Programming için projeler

## Hayvanat Bahçesi

Bir hayvanat bahçesindeki hayvanlar hakkındaki bilgileri takip etmek için bir sistem tasarlıyorsunuz.

![](diagram.png)

### Hayvanlar:

* Atlar (atlar, zebralar, eşekler vb.),

* Kedigiller (kaplanlar, aslanlar vb.),

* Kemirgenler (sıçanlar, kunduzlar vb.) gibi gruplardaki türlerle karakterize edilir.

* Hayvanlar hakkında depolanan bilgilerin çoğu tüm gruplamalar için aynıdır. 

* tür adı, ağırlığı, yaşı vb.

* Sistem ayrıca her hayvan için belirli ilaçların dozajını alabilmeli => getDosage ()

* Sistem Yem verme zamanlarını hesaplayabilmelidir => getFeedSchedule ()

* Sistemin bu işlevleri yerine getirme mantığı, her gruplama için farklı olacaktır. Örneğin, atlar için yem verme algoritması farklı olup, kaplanlar için farklı olacaktır.



Polimorfizm modelini kullanarak, yukarıda açıklanan durumu ele almak için bir sınıf diyagramı tasarlayın.

## License
[MIT](https://choosealicense.com/licenses/mit/)
