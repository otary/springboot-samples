# springboot-banner-samples

- 自定义banner
- 设置favicon


---
**核心类**
- org.springframework.boot.ResourceBanner

> 文本格式 -- 读取配置项 `banner.txt` 和 `banner.location` ，从配置项中获取真实的文件地址；如果配置中没有配置，会把配置项作为文件去加载
- org.springframework.boot.ImageBanner

> 图片格式 -- 加载配置项 `banner.image.location`，从配置项中获取真实的路径；如果没有配置 `banner.image.location`，转而依次加载 `banner.gif`、`banner.jpg`、 `banner.png` 这三个中存在的文件

---
**常用banner生成网站**
- http://www.network-science.de/ascii/
- http://patorjk.com/software/taag/
- http://www.degraeve.com/img2txt.php

---
