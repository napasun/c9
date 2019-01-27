//
//  ViewController.swift
//  13_3_viewConvertPoint
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var arrow: UIImageView!
    @IBOutlet weak var sky: UIView!
    @IBOutlet weak var drangonfly: UIImageView!
    
    @IBAction func catchTombo(_ sender: Any) {
        //좌표변환
        //sky 뷰의 좌표 drangonfly를 view 뷰 좌표계로 변환
        var point = view.convert(drangonfly.center, from: sky)
        
        point.x += arrow.bounds.width/2
        point.y -= arrow.bounds.height/2
        
        arrow.center = point
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

