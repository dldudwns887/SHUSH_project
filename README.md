# 📢📣 SHUSH Project 📢📣
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/e150e208-a4e0-45de-9624-7de29d4fa8bd)

## SHUSH Project란?

학교 주변의 심각한 소음 문제를 해결하기 위해 시작한 IoT 웹 연동 프로젝트입니다.
<br>
학교 주변 소음 데이터를 실시간으로 수집하고 웹페이지에서 시각화해주는 기능을 가지고있습니다.
<br>
소음이 어느정도 되는지 시각화 한다면, 주변 사람들에게 현재 유발하는 소음에 대한 경각심을 심어줄 수 있을 것이라 생각해 기획한 프로젝트입니다.

---

## 📋 주요 기능
- [`소음측정`]()
  - 소음측정기를 학교 주변에 설치한 뒤 실시간 데이터를 수집합니다.
- [`데이터 시각화`]()
  - 백엔드 서버에서 시간, 일, 월 별 데이터의 평균값을 계산해 DataBase에 저장합니다.
  - 저장한 평균값 데이터를 시각화 하여 웹사이트에서 누구든지 열람할 수 있게 합니다. 
---
## 🎤소음 측정기 by [이영준](https://github.com/dldudwns887)
### 3D프린터로 구조물 출력
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/7d833b32-690e-4d5d-a743-d41c268ea969)

### LED 전광판, Arduino, 음성 감지 센서와 구조물의 결합
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/f83faa5c-19a7-4126-8a66-ef78aae20c38)
#### LED 전광판에서는 실시간으로 감지되는 소음 수치와, 그 옆에 감정표현을 출력해 통해 현재의 소음 수치가 주변 거주민들에게 끼치는 영향을 간접적으로 보여줍니다.
<br>

![image](https://github.com/Garodden/SHUSH_project/assets/44630705/650b82cd-4aed-4ed2-bc33-39c708aecfa7)
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/e607f717-13e0-468e-a663-5936dae9c591)
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/a933b931-cd51-43f1-85b9-e0f2675acf5a)

### 통신 방식
#### 아두이노 파트
![image](https://github.com/user-attachments/assets/78e8f49c-e512-48b2-b3e1-0664ae3a30f2)
- Radio Frequency(RF)
  - 다른 통신에 비해 따로 서버나 WAN을 구축할 필요가 없음.
  - 높은 데이터 전송 속도 및 유연성 제공  
  - 이를 위해 RF 통신이 가능한 nRF24L01 부품을 사용
#### 통신 알고리즘
![image](https://github.com/user-attachments/assets/a72ebfec-9a31-4829-904e-cd288e310386)

#### 실패 내용
 - 낮은 부품 내구성
   - 소음측정현황판 특성상 하루에 12시간, 오랜 기간 동안 작동되어야만 하나 통신 부품이 버티지 못해 통신이 실패하는 경우가 발생.
 

### 실제 설치 사진
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/e3a93359-2874-4d93-aa26-6f57ab826525)

### 소음 측정기 알고리즘
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/2061ab20-64c9-4bbb-a7cc-c7edff019892)

---
## Backend by [서창덕](https://github.com/Garodden)

### Techstech flowchart
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/af9b2952-ccf7-4a29-8b5c-b2f802c7f53a)
### 백엔드 flowchart
![image](https://github.com/Garodden/SHUSH_project/assets/44630705/a3063c58-f750-47e0-9d09-0ae158b57c3e)

---
### 프론트엔드 UI
![main_page](https://github.com/Garodden/SHUSH_project/assets/44630705/3a66bc90-b6f1-4901-a68d-7501c661c3e0)
![graph_hover_mothly](https://github.com/Garodden/SHUSH_project/assets/44630705/f55c7e13-c405-4f1f-a534-068f3f86d4d8)
![graph_hover_hourly](https://github.com/Garodden/SHUSH_project/assets/44630705/fdfbc701-e344-40aa-a48d-fbb88ad1b57a)

![footer_4](https://github.com/Garodden/SHUSH_project/assets/44630705/1de343e4-8716-46ff-ae20-c6ad6785afb3)
![footer_3](https://github.com/Garodden/SHUSH_project/assets/44630705/75ace730-3d09-4b41-996f-d63ec9c4286b)
![footer_2](https://github.com/Garodden/SHUSH_project/assets/44630705/c4c50ac2-20f5-4bdd-b23d-88f4db8c0af2)
![footer_1](https://github.com/Garodden/SHUSH_project/assets/44630705/8d98c4c2-cc7a-44fd-b286-aa0d3de901a0)
![calender_graph](https://github.com/Garodden/SHUSH_project/assets/44630705/d1f95c35-4e17-4415-9724-09878473c60d)
![caldner_graph_2](https://github.com/Garodden/SHUSH_project/assets/44630705/e329d78b-b4fe-4a40-830e-5953257915ed)

[아이디어톤 (1).pptx](https://github.com/user-attachments/files/15800364/1.pptx)
![position_button](https://github.com/Garodden/SHUSH_project/assets/44630705/68ee47e1-e674-47a1-bbb3-19b9037fe2f6)
---
