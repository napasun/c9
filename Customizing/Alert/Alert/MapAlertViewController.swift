//
//  MapAlertViewController.swift
//  Alert
//
//  Created by estgames on 2017. 12. 20..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit
import MapKit

class MapAlertViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        let alertBtn = UIButton(type: .system)
        
        alertBtn.frame = CGRect(x: 0, y: 150, width: 100, height: 30)
        alertBtn.center.x = self.view.frame.width / 2
        alertBtn.setTitle("Map Alert", for: .normal)
        alertBtn.addTarget(self, action: #selector(mapAlert(_:)), for: .touchUpInside)
        
        self.view.addSubview(alertBtn)
    }
    
    @objc func mapAlert(_ sender: UIButton) {
        let alert = UIAlertController(title: nil, message: "여기가 맞습니까?", preferredStyle: .alert)
        
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel, handler: nil)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        
        alert.addAction(cancelAction)
        alert.addAction(okAction)
        
        //맵킷 관련
        let contentVC = UIViewController()
        
        let mapkitView = MKMapView(frame: CGRect(x: 0, y: 0, width: 0, height: 0))
        contentVC.view = mapkitView
        contentVC.preferredContentSize.height = 200
        
        //맵킷 뷰 속성 설정 축척, 핀
        let pos = CLLocationCoordinate2D(latitude: 37.514322, longitude: 126.894623)    //위치 정보 위/경도
        
        let span = MKCoordinateSpan(latitudeDelta: 0.005, longitudeDelta: 0.005)    //지도에서 보여줄 넓이 축척 낮을 수록 좁은 넚위를 확대시켜 보여준다.
        
        let region = MKCoordinateRegion(center: pos, span: span)    //지도 영역 정의
        //지도 뷰에 표시
        mapkitView.region = region
        mapkitView.regionThatFits(region)
        //위치를 핀으로 표시
        let point = MKPointAnnotation()
        point.coordinate = pos
        mapkitView.addAnnotation(point)
        
        alert.setValue(contentVC, forKeyPath: "contentViewController")
        
        
        self.present(alert, animated: false, completion: nil)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
