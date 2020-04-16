//
//  FrontViewController.swift
//  SideBar
//
//  Created by estgames on 2018. 1. 2..
//  Copyright © 2018년 estgames. All rights reserved.
//

import UIKit

class FrontViewController: UIViewController {

    @IBOutlet var sideBarButton: UIBarButtonItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        if let revealVC = self.revealViewController() {
            self.sideBarButton.target = revealVC
            self.sideBarButton.action = #selector(revealVC.revealToggle(_:))
            
            //제스처 추가
            self.view.addGestureRecognizer(revealVC.panGestureRecognizer())
        }
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
