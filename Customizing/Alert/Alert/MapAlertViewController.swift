//
//  MapAlertViewController.swift
//  Alert
//
//  Created by estgames on 2017. 12. 20..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit


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
        let contentVC = MapKitViewController()
        
        
        
        alert.setValue(contentVC, forKeyPath: "contentViewController")
        
        
        self.present(alert, animated: false, completion: nil)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
