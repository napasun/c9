//
//  MapKitViewController.swift
//  Alert
//
//  Created by estgames on 2017. 12. 20..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit
import MapKit

class MapKitViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        let mapkitView = MKMapView(frame: CGRect(x: 0, y: 0, width: 0, height: 0))
        self.view = mapkitView
        self.preferredContentSize.height = 200
        
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
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
