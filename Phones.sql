Create Database if not exists MobileShop;

Create table MobileShop.Product
(	
	productID INT(5) NOT NULL AUTO_INCREMENT,
	productName VARCHAR(100) NOT NULL UNIQUE,
	price Float(6,2) NOT NULL CHECK (price >= 0),
	description VARCHAR(10000) NOT NULL,
	stock Int(3) NOT NULL CHECK (stock >= 0),
	PRIMARY KEY (productID)
);

Create table MobileShop.User
(	
	userID INT(5) NOT NULL AUTO_INCREMENT,
	fName VARCHAR(100) NOT NULL,
	lName VARCHAR(100) NOT NULL,
	address VARCHAR(100) NOT NULL,
	county VARCHAR(100) NOT NULL,
	country VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	phone VARCHAR(100) NOT NULL,
	pass VARCHAR(100) NOT NULL,
	isAdmin BOOLEAN NOT NULL, 
	PRIMARY KEY (userID)
);

Create table MobileShop.Supplier
(	
	supplierID INT(5) NOT NULL AUTO_INCREMENT,
	supplierName Varchar(100) NOT NULL,
	address Varchar(100) NOT NULL,
	county Varchar(100) NOT NULL,
	country Varchar(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	phone Varchar(100) NOT NULL,
	PRIMARY KEY (supplierID)
);

Create table MobileShop.Orders	
(
	orderID INT(5) NOT NULL AUTO_INCREMENT,
	dateOrdered DATE NOT NULL,
	userID int(5) not null,
	PRIMARY KEY (orderID),
	constraint fkUserID FOREIGN KEY(userID) references MobileShop.User (userID)
);

Create table MobileShop.OrderProduct
(
	orderID INT(5) NOT NULL,
	productID INT(5) NOT NULL,
	quantity INT(3) NOT NULL CHECK (quantity > 0),
	constraint fkOrder FOREIGN KEY(orderID) references MobileShop.Orders (orderID),
	constraint fkproduct FOREIGN KEY(productID) references MobileShop.Product (productID),
	constraint pk PRIMARY KEY(orderID,productID)
);

Create table MobileShop.ProductSupplier
(
	productID INT(5) NOT NULL,
	supplierID INT(5) NOT NULL,
	CONSTRAINT fkProductPS FOREIGN KEY(productID) references MobileShop.Product (productID),
	CONSTRAINT fkSupplier FOREIGN KEY(supplierID) references MobileShop.Supplier (supplierID),
	CONSTRAINT pk PRIMARY KEY(productID, supplierID)
);		



-- DATA insertion

INSERT INTO  MobileShop.Product (productID ,  ProductName, price, description, stock) 
VALUES (NULL, 'Apple iPhone 6, 16Gb', '649.00', 'iPhone 6 isn’t just bigger — it’s better in every way. A 4.7-inch Retina HD display. An A8 chip with 64-bit desktop-class architecture. A new 8MP iSight camera with Focus Pixels. The Touch ID fingerprint identity sensor. Faster 4G and Wi-Fi. Longer battery life. And iOS 8 and iCloud. All in a 6.9mm thin seamless design.

4.7-inch (diagonal) Retina HD display with 1334x720 resolution
A8 chip with M8 motion coprocessor
8-megapixel iSight camera with Focus Pixels and True Tone flash
1080p HD video recording at 60 fps and slo-mo video recording at 240 fps
FaceTime HD camera
Touch ID fingerprint sensor
4G and 802.11ac Wi-Fi
iOS 8 and iCloud
Available in gold, silver or space grey', '5');

INSERT INTO  MobileShop.Product (productID ,  ProductName, price, description, stock) 
values (NULL,'Apple iPhone 6 Plus', '869.99', 'iPhone 6 Plus isn’t just bigger - it’s better in every way. A 5.5 inch Retina HD display. An A8 chip with 64-bit desktop-class architecture. A new 8MP iSight camera with Focus Pixels and optical image stabilisation. The Touch ID fingerprint identity sensor. Faster 4G and Wi-Fi. Longer battery life. And iOS 8 and iCloud. All in a 7.1mm thin seamless design. 5.5 inch (diagonal) Retina HD display with 1920 x 1080 resolution A8 chip with M8 motion coprocessor 8-megapixel iSight camera with Focus Pixels, True Tone flash and optical image stabilisation 1080p HD video recording at 60 fps and slo-mo video recording at 240 fps FaceTime HD camera Touch ID fingerprint sensor 4G and 802.11ac Wi-Fi iOS 8 and iCloud Available in gold, silver or space grey.', '4');

INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'HTC One A9 16Gb', '599.00', 'Design worth imitating. Photos the pros will admire. High-resolution audio.

The smartphone that gets all the important elements right. From the company that crafted the world''s first all-metal design, HTC again sets a new design standard. The HTC One A9 features a super-thin metal frame with an elegant finish, expandable SD card memory and edge-to-edge Corning Gorilla glass.

Unleash your inner photographer with the HTC One A9. Take blur-free photos with Optical Image Stabilisation (OIS). Save more image details for unsurpassed editing and creative control with RAW capture in Pro mode. Speed up your videos up to 12x for a dramatic effect with Hyperlapse.

The HTC One A9 features an edge- to-edge 5 inch full high definition, 1080p, and energy efficient screen. You get 40% more colour than a normal LCD screen for brilliant graphics and gaming, even in direct sunlight. Breathe new life into your music. Built-in DAC converts 16-bit audio to 24-bit high-resolution sound for richness and depth that you have never heard from a smartphone.

The HTC One A9 delivers the best sound quality on the market with Dolby audio surround and an all-new enhanced high-output amplifier. Connect to your everyday faster with Android 6.0 Marshmallow. Quickly realise your possibilities with Now on Tap* and Android Pay* and unlock it all with a tap of your finger. Download films, music and images 2x faster, and charge 40% faster with Qualcomm Quick Charge. 2.0 technology.', '2');

INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'HTC One M8s, 16Gb - Gunmetal', '419.00', 'The HTC One M8s smartphone is now even better AND cheaper – yes, you did read that right!

Boasting a superior camera, processor and battery, an already outstanding phone just got even better. Weighing 160g and just 9.6 mm thick, you still get a stunning 5 full HD inch screen that''s perfect for surfing the web, viewing video and typing messages.

A powerful octa-core processor ensures that everything happens fast. It also feels incredibly good in your hand thanks to a curvy aluminium unibody and speaker grills at the top and bottom.

The 13 megapixel rear camera captures crisp, vivid photos and 1080p HD video, while the 5 megapixel front camera is ideal for superior selfies and video chats.

HTC BoomSound makes all your music sound stunning. The built-in 16Gb of storage can be expanded by up to 128Gb using the microSD card slot. Also 4G compatible.

Useful info:

5 inch full HD touch screen (1920 x 1080)
Android 4.4 KitKat OS
HTC Blink Feed
2Gb RAM
Octo-core Snapdragon 615 processor
13 Mp rear camera with 1080p HD video
5 Mp front camera
BoomSound front-facing speakers
WiFi, 3G, DLNA, Bluetooth 4.0
4G compatible
16Gb built-in storage expandable by up to 128Gb via microSD card
H 146, W 70.6, D 9.6 mm
Weight: 160g
HTC One M8s smartphone - Gunmetal', '3');



INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'LG G3,16Gb - Gold', '349.00', 'The stylish LG G3 smartphone''s outstanding 5.5 inch HD+ touch screen is a real treat for your eyes.

Bring all your web surfing, video and photos to life in spectacular style thanks to a 1440 x 2560 QHD resolution (giving you a stunning 538 pixels per inch for incredibly detail and colour) that makes the most of the superb phablet-style screen size.

Everything happens smooth and fast thanks to a seriously powerful 2.5GHz QualComm Snapdragon 801 processor and the Android 4.4.2 KitKat operating system.

The cameras are equally impressive – a superb 13 megapixel rear camera with laser autofocus designed to be the fastest on the market, plus an LED flash, optical image stabilisation and Ultra HD video. You also get a 2.1 megapixel front-facing camera for video chats or selfies.

You get 16Gb of onboard storage, which can be expanded by up to a massive 128Gb by adding a microSD card, so you can carry around plenty of movies, games, photos and more.

A 3000mAh battery keeps you going all day and you also get support for wireless charging.

Useful info:

Snapdragon 801 quad core processor 2.5GHz
5.5 inch IPS + LCD touch screen(1440 x 2560, 538ppi)
13 Mp autofocus camera with image stabilisation and dual flash
2160p HD video at 30fps
2.1 Mp front-facing camera
16Gb storage expandable by up to 128Gb via microSD card slot
Android 4.4.2 KitKat OS
2Gb RAM
Wi-Fi
GPS
Bluetooth
Dolby Mobile Sound
Dimensions: 146.3 x 74.6 x 8.9 mm
Weight: 149g
LG G3 smartphone 16Gb - Gold', '2');


INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'LG G3 S, 8Gb - Black', '239.00', 'The LG G3 S is a compact and slimline smartphone packed with impressive features.

You get a 5 inch screen that brings all your web surfing, video, gaming photos to life thanks to a 1280 x 720 HD resolution in a phone that weighs only 134g.

Everything happens smooth and fast thanks to a Snapdragon 400 processor, 1Gb RAM and the Android 4.4.2 KitKat operating system.

The cameras are equally impressive – an 8 megapixel rear camera with laser autofocus designed to be the fastest on the market, plus an LED flash and HD video. You also get a 1.3 megapixel front-facing camera for video chats or selfies.

There''s 8Gb of onboard storage, which can be expanded by up to 64Gb by adding a microSD card, so you can carry around plenty of movies, games, photos and more.

The brushed metal look and curved edges complete an attractive smartphone that will keep you in touch and entertained wherever you go.

Useful info:

5 inch HD touch screen (1280x720)
Snapdragon 400 quad core processor 1.2GHz
1Gb RAM
8 Mp autofocus camera with laser autofocus and HD video
1.3 Mp front-facing camera
8Gb storage expandable by up to 64Gb via microSD card slot
Android 4.4.2 KitKat OS
Wi-Fi, GPS, Bluetooth 4.0
Dimensions: 137.7 x 69.6 x 10.3 mm
Weight: 134g
LG G3 S smartphone 16Gb', '2');


INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Microsoft Lumia 435 8Gb', '82.00', 'Upgradeable to Windows 10 when available. See Microsoft.com/mobile/windows10 for details.

The stylish Microsoft Lumia 435 is a versatile Windows 8.1 smartphone for a truly outstanding price.

The 4 inch touch screen combines with Windows 8.1 to let you tap and swipe your way through the things you love, you''ll have no problems getting to grips with this incredibly user-friendly phone. There''s even a planned upgrade to Windows 10 on the way!

There''s a 2 megapixel camera for shooting photos and video of your adventures, and there''s 8Gb of memory built in. If that''s not enough, it''s compatible with microSD cards up to 128Gb, so you can carry around lots of music, photos and video.

The Lumia 435 weighs only 134g, so it''s very comfortable in your hand, whether you''re making a call or surfing the web.

It comes with popular Microsoft services like Skype, Office and OneDrive – pre-installed and free – giving you a smartphone experience that’s normally found on more expensive high-end phones.

Useful info:

Perfect first smartphone
4 inch IPS LCD touch screen (800x480)
1.2GHz Snapdragon 200 dual core processor
8Gb storage, expandable by up to 128Gb using microSD card
Windows 8.1, planned upgrade to Windows 10
2 Mp camera (1600x1200) and front-facing VGA camera
Wi-Fi, 3G, GPS, Bluetooth 4.0
microUSB 2.0
1Gb RAM
H 118.1, W 64.7, D 11.7 mm
Weight: 134g
Microsoft Lumia 435 smartphone - Green
Colour: Green.', '3');

INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Samsung Galaxy S6 Edge, 64Gb', '699.00', 'When only the best will do, it''s time to get your hands on the Samsung Galaxy S6 Edge.

Wrapped in a sleek metal and glass body, it also boasts super-fast processing power, a state of the art camera, an improved fingerprint sensor and a 5.1 inch Super AMOLED touch screen featuring a market-leading 2560 x 1440 pixel resolution and curved Gorilla Glass 4.

There''s lots of power under the hood, with a cutting-edge octa-core Exynos processor and the Android Lollipop operating system.

A 16 megapixel rear camera lets you capture great photos and 4K video, with image stabilisation keeping blur at bay even in low light. There''s also a front-facing 5 megapixel camera for video chats and selfies.

Boost your security with a fingerprint sensor and the S6 even helps you stay in shape with an upgraded S Health App and heart rate monitor. A handy dashboard provides a simple view of your fitness, including records of your walking/running distance, calories, speed and duration.

With 64Gb of storage, you can carry plenty of photos, MP3s and video with you. You can also fast charge the battery – letting you watch 2 hours of HD video from 10 minutes charging.

Features:

5.1 inch Super AMOLED display (1440 x 2560, 557ppi)
Octa-core Exynos processor
3Gb RAM
Android 5.0.2 Lollipop
16 megapixel autofocus camera (2988x5312) with image stabilisation
5 megapixel front camera
Fingerprint sensor
Wi-Fi, 3G, 4G, Bluetooth® 4.0, GPS
64Gb storage
S-Voice commands
Size: 143.4 x 70.5 x 7 mm
Weight: 132g
Samsung Galaxy S6 Edge smartphone 64Gb', '5');

INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Samsung Galaxy S6-32Gb', '599.00', 'Wrapped in a sleek metal and glass body, the S6 boasts super-fast processing power, a state of the art camera, an improved fingerprint sensor and a superb 5.1 inch Super AMOLED touch screen featuring a market-leading 2560x1440 pixel resolution with incredible colours and superb detail.

There''s plenty of power under the hood, with a cutting-edge octa-core Exynos processor and the Android Lollipop operating system.

A 16 megapixel rear camera lets you capture great photos and 4K video, with image stabilisation keeping blur at bay even in low light. There''s also a front-facing 5 megapixel camera for video chats and selfies.

Boost your security with a fingerprint sensor and the S6 even helps you stay in shape with an upgraded S Health App and heart rate monitor. A handy dashboard provides a simple view of your fitness, including records of your walking/running distance, calories, speed and duration.

With 32Gb of internal storage, you can carry plenty of photos, MP3s and video with you. You can also fast charge the battery – letting you watch around 2 hours of HD video from 10 minutes charging.

Features:

5.1 inch Super AMOLED display (1440 x 2560, 557ppi)
Octa-core Exynos processor
3Gb RAM
Android 5.0.2 Lollipop
16 Mp autofocus camera (2988x5312) with image stabilisation
5 Mp front camera
Fingerprint sensor
Wi-Fi, 3G, 4G, Bluetooth® 4.0, GPS
32Gb storage
S-Voice language commands
Size: 143.4 x 70.5 x 6.8 mm
Weight: 136 g
Samsung Galaxy S6 smartphone', '5');

INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Samsung Galaxy Ace 3, 4Gb', '139.00', 'The Samsung Galaxy Ace 3 is a slimline and stylish smartphone packed with great features.

You can enjoy web browsing, watch movies and play games on the scratch-resistant 4 inch display and it weighs only 115g, so it feels incredibly comfortable in your hand. Perfect for youngsters, smartphone novices and occasional users.

There''s a 5 megapixel camera with autofocus and an LED flash that lets you capture that special moment then share it on Facebook or in a message. The Sound and Shot feature even lets you record sound while taking a photo. A secondary VGA front camera is ideal for video chats.

S Translator offers instantaneous translation when messaging with global users. S Travel offers recommendations, travel guides and more for your trips. Smart Stay knows if you are looking at the display, so keeps the screen bright when you are reading a webpage, viewing photos and more.

S Voice uses your voice to wake up the phone, answer incoming calls or even take a photo.

You get 4Gb of storage built in, with the option of adding up to another 64Gb using a microSD card, so you can carry around plenty of music, movies, photos and more.

Features:

4 inch 480 x 800 TFT display
1.2Ghz dual core processor
1Gb RAM
4Gb storage expandable by up to 64Gb via microSD card
5 Mp autofocus rear-facing camera
HD (1280 x 720) @30fps video recording
VGA front camera
S Voice functionality
Games Hub
WiFi, 3G, Bluetooth 4.0, 4G compatible
H 121.2, W 62.7, D 9.8 mm
Weight: 115g
Samsung Galaxy Ace 3 - White', '6');


INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Sony Xperia C4, 16Gb', '299.00', 'The Sony Xperia C4 is packed with first-class smartphone features, including a superior selfie camera.


The 5.5 inch full HD screen with enhanced sharpness and contrast is a treat for your eyes, with Super Vivid Mode ensuring you can see everything clearly even in bright sunlight.

Just 7.9 mm thin and weighing 147g, it feels incredibly comfortable in your hand, particularly for a big screen phone. You also get a long-lasting battery that can keep going for up to 2 days.

A 13 megapixel rear camera with an Exmor RS sensor lets you can frame, shoot and review all your footage in rich colour, contrast and detail. Image stabilisation gives you blur-free photos even in low light and you can shoot 1080p full HD video.

But the 5 megapixel front camera is equally impressive, thanks to a wide angle lens and LED flash that ensure perfect selfie group shots with everyone in the frame. Settings are automatically optimised to capture sharp, clear portraits, even in low light, with the soft LED flash providing natural-looking light that ensures everyone is looking their best. 

An octa-core processor and 2Gb RAM ensure everything happens fast, including downloads and playing games.

Sony 3D Surround Sound technology and front-facing speakers create superior audio. There''s also 16Gb of internal storage that''s expandable by 128Gb using a microSD card.

Features:
Octa-core processor 1.7 GHz
5.5 inch IPS LCD touch screen (1920 x 1080, 401 ppi)
2Gb RAM
Android Lollipop 5.0
Mobile BRAVIA® Engine 2
16Gb storage, expandable by up to 128Gb using a microSD card
13 Mp rear camera with Exmor RS sensor and autofocus
HD 1080p video
5 Mp front camera with Exmor R and flash
Wi-Fi, Bluetooth® 4.1, NFC, GPS
2600mAh battery
H 150.3, W 77.4, D 7.9 mm
Weight: 147g
Sony Xperia C4 smartphone


Camera: Y
Depth: 7.9 MM
Height: 150.3 MM
Width: 77.4 MM
Front Facing Camera: Y
Main Camera: Y
Memory (in Gigabyte): 16
Screen Size: 5.5"
Screen Type: Touchscreen
Sim Type: Pay as you go
Storage: Micro SD', '2');


INSERT INTO MobileShop.Product (productID,  ProductName, price, description, stock) 
VALUES (NULL, 'Sony Xperia Z3 Plus, 32Gb', '615.00', 'The Sony Xperia Z3+ just got even better – lighter, thinner yet somehow packed with superior features!

Now just 6.9 mm thin and weighing only 144g, it feels incredibly comfortable in your hand as you enjoy the stunning 5.2 inch full HD Triluminos touch screen.

The outstanding 20.7 megapixel camera lets you can frame, shoot and review all your footage in rich colour, contrast and detail. You get a sensor that''s 30% larger than standard, so you can shoot 4K Ultra HD videos 4 times sharper than Full HD. The rear camera has also been upgraded to 5.1 megapixels with full HD video recording.

The Snapdragon 810 octa-core processor and 3Gb RAM do everything at the speed of light, including downloading and play games, browsing the web and watching videos.

The Xperia Z3+ is dust and water-resistant, so you''ll never fear dropping your phone in the sink again - you can even shoot photos under water! There''s 32Gb of internal storage that''s expandable by 128Gb using a microSD card.

Sony 3D Surround Sound technology and front-facing speakers create superior audio.

Useful info:

Qualcomm Snapdragon 810 SoC octa-core processor
5.2 inch full HD Triluminos display (1920x1080)
32Gb storage expandable by up to 128Gb via microSD card
3Gb RAM
Android 5.0 Lollipop
20.7 Mp camera (5248x3936) with 4K video recording
5.1 Mp front camera
IP168 Waterproof and dust protected
3D Surround Sound technology
Long lasting 2930mAh battery
Weight 144 g
H 146, W 72, D 6.9 mm
Sony Xperia Z3+ smartphone phablet', '1');


INSERT INTO MobileShop.User (userID, fName, lName, address, county, country, email, phone, pass, isAdmin) 
VALUES (NULL, 'Sergio', 'Vilaseco', 'address', 'louth', 'ireland', 'test@test.com', '0859876543','password','1');

INSERT INTO MobileShop.User (userID, fName, lName, address, county, country, email, phone, pass, isAdmin) 
VALUES (NULL, 'Brian', 'Mc Manus', 'address', 'louth', 'ireland', 'test1@test.com', '0859876543','password','1');

INSERT INTO MobileShop.User (userID, fName, lName, address, county, country, email, phone, pass, isAdmin) 
VALUES (NULL, 'Niall', 'Mulready', 'address', 'louth', 'ireland', 'test2@test.com', '0859876543','password','0');

INSERT INTO MobileShop.Orders (orderID, dateOrdered, userID) VALUES
(1, '2015-12-03', 1),
(2, '2015-12-02', 2),
(3, '2015-11-09', 3),
(4, '2015-12-07', 1);

INSERT INTO MobileShop.OrderProduct (orderID, productID, quantity) VALUES
(1, 1, 3),
(1, 4, 1),
(2, 8, 1),
(3, 11, 2);

INSERT INTO MobileShop.Supplier (supplierID, supplierName, address, county, country, email, phone) 
VALUES 
(NULL, 'Sony', 'Sony Address', 'Dublin', 'Ireland', 'suppor@Sony.ie', '0856530174'),
(NULL, 'Apple', 'Apple Address', 'Dublin', 'Ireland', 'suppor@apple.ie', '0147182937'),
(NULL, 'HTC', 'HTC Address', 'Dublin', 'Ireland', 'suppor@HTC.ie', '0757169273'),
(NULL, 'LG', 'LG Address', 'Dublin', 'Ireland', 'suppor@LG.ie', '0987629372'),
(NULL, 'Samsung', 'Samsung Address', 'Dublin', 'Ireland', 'suppor@samsung.ie', '0144562937'),
(NULL, 'Microsoft', 'Microsoft Address', 'Dublin', 'Ireland', 'suppor@Microsoft.ie', '0144502437');

ALTER TABLE product ADD totalRating Int(100);
ALTER TABLE product ADD noOfRatings Int(100);


